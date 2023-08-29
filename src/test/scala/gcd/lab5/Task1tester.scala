package lab5
 import chisel3._
 import chisel3.tester._
 import org.scalatest.FreeSpec
 import chisel3.experimental.BundleLiterals._

 class Task1tester extends FreeSpec with ChiselScalatestTester {
     "adder tester" in {
         test(new Adder(4)){ a =>
         a. io.in0.poke(1.U)
        a.io.in1.poke(1.U)
         a.io.sum.expect(2.U)
         a.clock.step(1)


    }
 }
 }
    

