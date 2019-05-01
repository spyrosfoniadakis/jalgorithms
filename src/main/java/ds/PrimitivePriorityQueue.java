/*
 * Copyright 2019 Spyridon Foniadakis
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ds;

// TODO: Consider deleting the file if the PrimitiveHeap interface becomes package-private

/**
 * It is an interface defined only for logical consistency and guidance. A priority queue implementation
 * is based on the Heap class and interface hierarchies, so this interface serves none significant purpose
 * other than for the users who would like to implement their own PrioritiyQueue implementation; it would
 * be confusing to extend directly from Heap-related classes or interfaces. So this interface and any
 * PriorityQueue-related interface or class serves as an alias for the Heap-related definition it inherits from.
 */
public interface PrimitivePriorityQueue extends PrimitiveHeap {

}
