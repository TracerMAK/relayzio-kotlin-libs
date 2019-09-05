package com.relayzio.kotlin.containers

/**
 * An implementation of an immutable array container. The backing
 * Array structure prevents the changing of any index values after
 * the initial creation. The creation methods of ImmutableArray objects
 * tries to mimic those of the standard Kotlin Array type.
 */
class ImmutableArray<T> (vararg values: T?) {
  private val data: Array<out T?>
  val size: Int
  
  init {
    data = values
    size = data.size
  }
  
  /**
   * https://kotlinlang.org/docs/reference/inline-functions.html#reified-type-parameters
   */
  companion object {
    operator inline fun <reified T> invoke(size: Int, noinline init: (Int) -> T) : ImmutableArray<T> {
      return ImmutableArray(*Array<T>(size, init))
    }
  }

  operator fun get(index: Int): T? {
    return data[index]
  }

  operator fun iterator(): Iterator<T?> {
    return data.iterator()
  }
  
  

}

