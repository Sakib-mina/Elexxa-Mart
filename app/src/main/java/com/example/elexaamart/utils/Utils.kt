package com.example.elexaamart.utils

import android.widget.EditText


fun EditText.isEmpty(): Boolean{
    return if (this.text.toString().isEmpty()) {
        this.error = "this place need to be fill up"
        true
    } else {
        false
    }
}