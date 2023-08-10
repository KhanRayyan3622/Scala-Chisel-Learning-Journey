package Lab1
//import chiseltest._

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class Exercise1test extends FreeSpec with ChiselScalatestTester {
  "CounterTester file" in {
    test(new Counter(3.S)) { b =>
      b.clock.step(8)
       b.io.result.expect(0.B)

    }
  }
}