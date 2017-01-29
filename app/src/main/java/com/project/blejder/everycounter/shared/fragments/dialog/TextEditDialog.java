package com.project.blejder.everycounter.shared.fragments.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;

import com.project.blejder.everycounter.databinding.DetailFragmentEditTextBinding;

public class TextEditDialog extends DialogFragment {


    //region Consts
    private static final String TYPE_BUNDLE  = "type_bundle";
    private static final String TITLE_BUNDLE = "title_bundle";
    //endregion

    //region Fields
    DetailFragmentEditTextBinding binding;

    TextEditDialogCallback callback;
    //endregion

    //region newInstances
    public static TextEditDialog newInstance(Type type, String title) {
        TextEditDialog dialog      = new TextEditDialog();
        int            typeOrdinal = type.ordinal();
        Bundle         bundle      = new Bundle();
        bundle.putInt(TYPE_BUNDLE, typeOrdinal);
        bundle.putString(TITLE_BUNDLE, title);
        dialog.setArguments(bundle);
        return dialog;
    }
    //endregion

    //region LifeCycle
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DetailFragmentEditTextBinding.inflate(inflater);

        setUpButtons();

        Bundle arguments = getArguments();
        Type   type      = Type.values()[arguments.getInt(TYPE_BUNDLE)];
        String title     = arguments.getString(TITLE_BUNDLE);

        binding.title.setText(title);
        binding.editText.setInputType(type.getInputType());
        return binding.getRoot();
    }

    private void setUpButtons() {
        binding.cancelButton.setOnClickListener(v -> dismiss());
        binding.saveButton.setOnClickListener(v -> {
            dismiss();
            if (callback != null) {
                callback.dialogResult(binding.editText.getText().toString());
            }
        });
    }
    //endregion

    public enum Type {
        Text,
        Number;

        int getInputType() {
            switch (this) {
                case Text:
                    return EditorInfo.TYPE_CLASS_TEXT;
                case Number:
                    return EditorInfo.TYPE_NUMBER_FLAG_DECIMAL;
            }
            return EditorInfo.TYPE_CLASS_TEXT;
        }
    }

    public interface TextEditDialogCallback {
        void dialogResult(String result);
    }
}
