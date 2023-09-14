package Lab6
import chisel3._
import chisel3.tester._
 import org.scalatest.FreeSpec
 import chisel3.experimental.BundleLiterals._

 class Task1tester extends FreeSpec with ChiselScalatestTester {
     "T1  tester" in {
         test(new counter1(20)){ a =>
         a.clock.step(100)
         a.io.out.expect(16.U)
         }
        }
    }