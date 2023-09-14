package Lab6
import chisel3._
import chisel3.tester._
 import org.scalatest.FreeSpec
 import chisel3.experimental.BundleLiterals._

 class Ex2tester extends FreeSpec with ChiselScalatestTester {
     "packet tester" in {
         test(new counter(4)){ a =>
         a.clock.step(1)
         a.io.out.expect("b0010".U)
        // a.io.out.expect("b1111".U)
         }
        }
    }