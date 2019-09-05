package com.relayzio.kotlin.tests.containers

import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertNull
import org.junit.Test

import com.relayzio.kotlin.containers.ImmutableArray

class ImmutableArrayTests {

  @Test
  fun constructorWithIntArgs() : Unit {
    val imm = ImmutableArray<Int>(1, 2, 3, 4, 5)

    assertNotNull(imm)
    assertEquals(3, imm.get(2))
    assertEquals(5, imm[4])
    assertEquals(5, imm.size)
  }

  @Test
  fun constructorWithStringArgs() : Unit {
    val imm = ImmutableArray<String>("Hello", "to", "you", "!")

    assertNotNull(imm)
    assertEquals("to", imm.get(1))
    assertEquals("!", imm[3])
    assertEquals(4, imm.size)
  }

  @Test
  fun constructorWithArrayParam() : Unit {
    val arr = Array<Int>(3, {i -> i * 2})
    // Convert varargs to an immay with spread operator (*)
    val imm = ImmutableArray<Int>(*arr)
    
    assertNotNull(imm)
    assertEquals(2, imm.get(1))
    assertEquals(4, imm[2])
    assertEquals(3, imm.size)
  }

  @Test
  fun constructorWithNullArg() : Unit {
    val imm = ImmutableArray<Int>(1, 2, null, 4, 5)

    assertNotNull(imm)
    assertNull(imm.get(2))
    assertEquals(5, imm[4])
    assertEquals(5, imm.size)
  }    

  /*
  @Test
  fun constructorWithIntArrayParam() : Unit {
    val arr = IntArray(3, {i -> i * 2})
    // Convert varargs to an array with spread operator (*)
    val imm = ImmutableArray<Int>(*arr)

    assertNotNull(imm)
    assertEquals(2, imm.get(1))
    assertEquals(4, imm[2])
    assertEquals(3, imm.size)
  }
  */
  
  @Test
  fun createWithFactoryFunction() : Unit {
    val imm = ImmutableArray<Int>(5, {i -> i * 2})
    
    assertNotNull(imm)
    assertEquals(6, imm[3])
    assertEquals(2, imm.get(1))
    assertEquals(5, imm.size)
  }

  @Test
  fun intElementNotMutable() : Unit {
    val arr = arrayOf(0, 1, 2, 3, 4, 5)
    val imm = ImmutableArray<Int>(*arr)

    assertNotNull(imm)    
    arr[2] = 10
    assertEquals(10, arr[2])
    assertEquals(2, imm[2])
  }

  @Test
  fun validIterator() : Unit {
    val imm = ImmutableArray<Int>(1, 2, 3, 4, 5)
    assertNotNull(imm)
    val iter = imm.iterator()
    iter.next()
    assertEquals(2, iter.next())
  }
}