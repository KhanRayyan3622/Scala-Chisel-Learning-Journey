package Lab6


import chisel3._
import chisel3.tester._
 import org.scalatest.FreeSpec
 import chisel3.experimental.BundleLiterals._

 class Ex4tester extends FreeSpec with ChiselScalatestTester {
     "ex3  tester" in {
         test(new Queue){ a =>
            a.io.in.valid.poke(0.B)
               a.io.in.bits.poke(2.U)
                        a.clock.step(5)

                  a.io.in.ready.expect(0.B)

                  
            a.io.in.ready.poke(0.B)
            a.clock.step(5)
            a.io.in.valid.expect(0.B)
            a.io.in.bits.expect(2.U)
         

        
        
        }
        }
    }

