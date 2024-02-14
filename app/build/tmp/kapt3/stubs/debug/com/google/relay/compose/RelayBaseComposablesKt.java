package com.google.relay.compose;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, d1 = {"\u0000\u00cc\u0001\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0088\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0013\u00a2\u0006\u0002\b\u0014H\u0003\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016\u001a\u00dd\u0001\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u0018\u001a\u00020\t2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u000b2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\t2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00052\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010\u0013\u00a2\u0006\u0002\b\u0014\u00a2\u0006\u0002\b%H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b&\u0010\'\u001a\u0083\u0001\u0010(\u001a\u00020\u00012\b\b\u0002\u0010)\u001a\u00020*2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\r2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b-\u0010.\u001a\u00d9\u0001\u0010/\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u0002002\b\b\u0002\u00101\u001a\u0002022\b\b\u0002\u00103\u001a\u0002022\b\b\u0002\u00104\u001a\u0002022\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u00020\t2\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\t2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\r2\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020B2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010FH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bG\u0010H\u001a\u00d9\u0001\u0010/\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020I2\b\b\u0002\u00101\u001a\u0002022\b\b\u0002\u00103\u001a\u0002022\b\b\u0002\u00104\u001a\u0002022\n\b\u0002\u00105\u001a\u0004\u0018\u0001062\b\b\u0002\u00107\u001a\u00020\t2\b\b\u0002\u00108\u001a\u00020\t2\b\b\u0002\u00109\u001a\u00020\t2\b\b\u0002\u0010:\u001a\u00020;2\b\b\u0002\u0010<\u001a\u00020=2\b\b\u0002\u0010>\u001a\u00020\r2\b\b\u0002\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020B2\n\b\u0002\u0010C\u001a\u0004\u0018\u00010D2\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010FH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bG\u0010J\u001aG\u0010K\u001a\u00020\u00012\b\b\u0002\u0010L\u001a\u00020*2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\rH\u0007\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\bM\u0010N\u001a\u0018\u0010O\u001a\u00020P2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000b\u001aB\u0010Q\u001a\u00020\u0003*\u00020\u00032\u0010\b\u0002\u0010R\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010S2\u0010\b\u0002\u0010T\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010S2\u0010\b\u0002\u0010U\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010SH\u0007\u001a1\u0010V\u001a\u00020\u0003*\u00020\u00032\u0006\u0010W\u001a\u00020\t2\u0017\u0010X\u001a\u0013\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0013\u00a2\u0006\u0002\b%H\u0086\b\u00f8\u0001\u0002\u0082\u0002\u0012\n\u0005\b\u00a1\u001e0\u0001\n\u0002\b\u0019\n\u0005\b\u009920\u0001\u00a8\u0006Y"}, d2 = {"RelayBaseComposable", "", "modifier", "Landroidx/compose/ui/Modifier;", "padding", "Landroidx/compose/foundation/layout/PaddingValues;", "clip", "Lcom/google/relay/compose/Clip;", "clipToParent", "", "radius", "", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "strokeWidth", "strokeColor", "borderAlignment", "Lcom/google/relay/compose/BorderAlignment;", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "RelayBaseComposable-xDvQUfU", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Lcom/google/relay/compose/Clip;ZDJDJLcom/google/relay/compose/BorderAlignment;Lkotlin/jvm/functions/Function1;)V", "RelayContainer", "isStructured", "arrangement", "Lcom/google/relay/compose/RelayContainerArrangement;", "itemSpacing", "mainAxisAlignment", "Lcom/google/relay/compose/MainAxisAlignment;", "crossAxisAlignment", "Lcom/google/relay/compose/CrossAxisAlignment;", "scrollable", "scrollAnchor", "Lcom/google/relay/compose/ScrollAnchor;", "scrollPadding", "Lcom/google/relay/compose/RelayContainerScope;", "Lkotlin/ExtensionFunctionType;", "RelayContainer-sgwrhAQ", "(Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;DDLcom/google/relay/compose/BorderAlignment;JLcom/google/relay/compose/Clip;ZJZLcom/google/relay/compose/RelayContainerArrangement;DLcom/google/relay/compose/MainAxisAlignment;Lcom/google/relay/compose/CrossAxisAlignment;ZLcom/google/relay/compose/ScrollAnchor;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function1;)V", "RelayImage", "image", "Landroidx/compose/ui/graphics/painter/Painter;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "RelayImage-JzRRBIE", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/layout/ContentScale;DLandroidx/compose/foundation/layout/PaddingValues;Lcom/google/relay/compose/Clip;ZJDJLcom/google/relay/compose/BorderAlignment;)V", "RelayText", "Landroidx/compose/ui/text/AnnotatedString;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "height", "letterSpacing", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "underline", "strikethrough", "italic", "maxLines", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "color", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "case", "Lcom/google/relay/compose/Case;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "RelayText-TdwIXGY", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/text/AnnotatedString;JJJLandroidx/compose/ui/text/font/FontWeight;ZZZIIJILcom/google/relay/compose/Case;Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/foundation/layout/PaddingValues;Lcom/google/relay/compose/Clip;DLandroidx/compose/ui/graphics/Shadow;)V", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;JJJLandroidx/compose/ui/text/font/FontWeight;ZZZIIJILcom/google/relay/compose/Case;Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/foundation/layout/PaddingValues;Lcom/google/relay/compose/Clip;DLandroidx/compose/ui/graphics/Shadow;)V", "RelayVector", "vector", "RelayVector-xwkQ0AY", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Modifier;Landroidx/compose/foundation/layout/PaddingValues;Lcom/google/relay/compose/Clip;J)V", "getShape", "Landroidx/compose/ui/graphics/Shape;", "tappable", "onTap", "Lkotlin/Function0;", "onDoubleTap", "onLongPress", "thenIf", "condition", "factory", "app_debug"})
public final class RelayBaseComposablesKt {
    
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Stable
    @kotlin.OptIn(markerClass = {androidx.compose.foundation.ExperimentalFoundationApi.class})
    public static final androidx.compose.ui.Modifier tappable(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier $this$tappable, @org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function0<kotlin.Unit> onTap, @org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function0<kotlin.Unit> onDoubleTap, @org.jetbrains.annotations.Nullable
    kotlin.jvm.functions.Function0<kotlin.Unit> onLongPress) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final androidx.compose.ui.graphics.Shape getShape(@org.jetbrains.annotations.NotNull
    com.google.relay.compose.Clip clip, double radius) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final androidx.compose.ui.Modifier thenIf(@org.jetbrains.annotations.NotNull
    androidx.compose.ui.Modifier $this$thenIf, boolean condition, @org.jetbrains.annotations.NotNull
    kotlin.jvm.functions.Function1<? super androidx.compose.ui.Modifier, ? extends androidx.compose.ui.Modifier> factory) {
        return null;
    }
}