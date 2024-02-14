package com.google.relay.compose;

import java.lang.System;

@androidx.compose.runtime.Immutable
@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J)\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\b\u0010\tJ\u001e\u0010\n\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH&J\u001e\u0010\u000f\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH&\u0082\u0002\u000b\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/google/relay/compose/RelayContainerScope;", "", "boxAlign", "Landroidx/compose/ui/Modifier;", "alignment", "Landroidx/compose/ui/Alignment;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "boxAlign-GrvxvIE", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Alignment;J)Landroidx/compose/ui/Modifier;", "columnWeight", "weight", "", "fill", "", "rowWeight", "app_debug"})
@androidx.compose.foundation.layout.LayoutScopeMarker
public abstract interface RelayContainerScope {
    
    @org.jetbrains.annotations.NotNull
    public abstract androidx.compose.ui.Modifier columnWeight(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier $this$columnWeight, float weight, boolean fill);
    
    @org.jetbrains.annotations.NotNull
    public abstract androidx.compose.ui.Modifier rowWeight(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier $this$rowWeight, float weight, boolean fill);
    
    @kotlin.Metadata(mv = {1, 8, 0}, k = 3)
    public final class DefaultImpls {
    }
}