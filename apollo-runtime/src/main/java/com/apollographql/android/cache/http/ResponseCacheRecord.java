package com.apollographql.android.cache.http;

import javax.annotation.Nonnull;

import okio.Source;

public interface ResponseCacheRecord {
  @Nonnull Source headerSource();

  @Nonnull Source bodySource();

  void close();
}
