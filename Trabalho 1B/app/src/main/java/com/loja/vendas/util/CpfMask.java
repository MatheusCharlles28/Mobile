package com.loja.vendas.util;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class CpfMask implements TextWatcher {
    private EditText editText;
    private boolean isUpdating = false;

    public CpfMask(EditText editText) {
        this.editText = editText;
    }

    @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
    @Override public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void afterTextChanged(Editable s) {
        if (isUpdating) return;
        isUpdating = true;

        String digits = s.toString().replaceAll("[^0-9]", "");
        if (digits.length() > 11) digits = digits.substring(0, 11);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < digits.length(); i++) {
            sb.append(digits.charAt(i));
            if (i == 2 || i == 5) sb.append('.');
            if (i == 8) sb.append('-');
        }

        editText.setText(sb.toString());
        editText.setSelection(sb.length());
        isUpdating = false;
    }
}
