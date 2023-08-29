package lab5

import chisel3._
 import chisel3.tester._
 import org.scalatest.FreeSpec
 import chisel3.experimental.BundleLiterals._

 class Ex3tester extends FreeSpec with ChiselScalatestTester {
     "operator tester" in {
         test(new Operator(3,UInt(16.W))(_-_)){ a =>
         a.io.in(0).poke(10.U)
        a.io.in(1).poke(1.U)
         a.io.in(2).poke(2.U)
        a.clock.step(1)
         a.io.out(0).expect(7.U)
         //a.clock.step(1)
         }
        }
    }

