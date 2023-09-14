package Lab6
import chisel3._
import chisel3.tester._
 import org.scalatest.FreeSpec
 import chisel3.experimental.BundleLiterals._

 class Task4tester extends FreeSpec with ChiselScalatestTester {
     "T4  tester" in {
         test(new up_down_counter(20)){ a =>
          a.io.up_down.poke(1.B)  
         a.clock.step(100)
         a.io.out.expect(1.U)
         }
        }
    }

