package com.lespsan543.apppeliculas.peliculas.ui.viewModel;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010!\u001a\u00020\"J\u0014\u0010#\u001a\u00020\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0%J\u0014\u0010&\u001a\u00020\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0%J\b\u0010\'\u001a\u00020\"H\u0002J\u0010\u0010(\u001a\u00020\"2\u0006\u0010)\u001a\u00020\tH\u0002J\u000e\u0010*\u001a\u00020\"2\u0006\u0010\n\u001a\u00020\tJ\u000e\u0010+\u001a\u00020\"2\u0006\u0010\u0013\u001a\u00020\tJ\u000e\u0010,\u001a\u00020\"2\u0006\u0010\u0017\u001a\u00020\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\u0013\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0016\u0010\u0010\u001a\u0004\b\u0014\u0010\f\"\u0004\b\u0015\u0010\u000eR+\u0010\u0017\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8F@BX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u001a\u0010\u0010\u001a\u0004\b\u0018\u0010\f\"\u0004\b\u0019\u0010\u000eR \u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00050\u001cX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 \u00a8\u0006-"}, d2 = {"Lcom/lespsan543/apppeliculas/peliculas/ui/viewModel/LogInOrRegisterViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "_wrong", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "<set-?>", "", "email", "getEmail", "()Ljava/lang/String;", "setEmail", "(Ljava/lang/String;)V", "email$delegate", "Landroidx/compose/runtime/MutableState;", "firestore", "Lcom/google/firebase/firestore/FirebaseFirestore;", "name", "getName", "setName", "name$delegate", "password", "getPassword", "setPassword", "password$delegate", "wrong", "Lkotlinx/coroutines/flow/StateFlow;", "getWrong", "()Lkotlinx/coroutines/flow/StateFlow;", "setWrong", "(Lkotlinx/coroutines/flow/StateFlow;)V", "closeDialog", "", "createUser", "onSuccess", "Lkotlin/Function0;", "logIn", "reset", "saveUser", "username", "writeEmail", "writeName", "writePassword", "app_debug"})
public final class LogInOrRegisterViewModel extends androidx.lifecycle.ViewModel {
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    private final com.google.firebase.firestore.FirebaseFirestore firestore = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState email$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState password$delegate = null;
    @org.jetbrains.annotations.NotNull
    private final androidx.compose.runtime.MutableState name$delegate = null;
    private kotlinx.coroutines.flow.MutableStateFlow<java.lang.Boolean> _wrong;
    @org.jetbrains.annotations.NotNull
    private kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> wrong;
    
    public LogInOrRegisterViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getEmail() {
        return null;
    }
    
    private final void setEmail(java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getPassword() {
        return null;
    }
    
    private final void setPassword(java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getName() {
        return null;
    }
    
    private final void setName(java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getWrong() {
        return null;
    }
    
    public final void setWrong(@org.jetbrains.annotations.NotNull
    kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> p0) {
    }
    
    public final void createUser(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    private final void saveUser(java.lang.String username) {
    }
    
    public final void logIn(@org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess) {
    }
    
    private final void reset() {
    }
    
    public final void closeDialog() {
    }
    
    public final void writeEmail(@org.jetbrains.annotations.NotNull
    java.lang.String email) {
    }
    
    public final void writeName(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
    }
    
    public final void writePassword(@org.jetbrains.annotations.NotNull
    java.lang.String password) {
    }
}