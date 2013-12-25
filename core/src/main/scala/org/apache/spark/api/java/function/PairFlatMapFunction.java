/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.api.java.function;

import scala.Tuple2;
import scala.reflect.ClassManifest;
import scala.reflect.ClassManifest$;

import java.io.Serializable;

/**
 * A function that returns zero or more key-value pair records from each input record. The
 * key-value pairs are represented as scala.Tuple2 objects.
 */
// PairFlatMapFunction does not extend FlatMapFunction because flatMap is
// overloaded for both FlatMapFunction and PairFlatMapFunction.
public abstract class PairFlatMapFunction<T, K, V>
  extends WrappedFunction1<T, Iterable<Tuple2<K, V>>>
  implements Serializable {

  public ClassManifest<K> keyType() {
    return (ClassManifest<K>) ClassManifest$.MODULE$.fromClass(Object.class);
  }

  public ClassManifest<V> valueType() {
    return (ClassManifest<V>) ClassManifest$.MODULE$.fromClass(Object.class);
  }
}