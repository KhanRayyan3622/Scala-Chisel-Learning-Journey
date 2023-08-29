package lab5
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class Ex2Tester extends FreeSpec with ChiselScalatestTester {
  "Lab4 Tester file" in {
    test(new eMux(UInt(4.W))){a =>
        a.io.in1.poke(3.U)
        a.io.in2.poke(6.U)
        a.io.sel.poke(1.B)
        a.io.out.expect(3.U)
    a.clock.step(2)
    }
}
}