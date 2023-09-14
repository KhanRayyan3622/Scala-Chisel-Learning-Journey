package Lab6

import chisel3._
import chisel3.tester._
 import org.scalatest.FreeSpec
 import chisel3.experimental.BundleLiterals._

 class Task2tester extends FreeSpec with ChiselScalatestTester {
     "T2  tester" in {
         test(new counter_with_xor){ a =>
         a.clock.step(10)
         a.io.out.expect(1.U)
         }
        }
    }

