package gcd.Lab8

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class ex1Tester extends FreeSpec with ChiselScalatestTester {
  "lab8 Tester file" in {
    test(new MaskedRead){a =>
        a.io.enable.poke(1.B)
          a.io.write.poke(1.B)
            a.io.addr.poke(5.U)
               
            a.io.mask(0).poke(1.B)
               a.io.mask(1).poke(1.B)
                  a.io.mask(2).poke(1.B)
                     a.io.mask(3).poke(1.B)


                     a.io.dataIn(0).poke(5.B)
                       a.io.dataIn(1).poke(5.B)
                         a.io.dataIn(2).poke(5.B)
                            a.io.dataIn(3).poke(5.B)

                            a.clock.step(1)
                          a.io.dataOut(0).expect(5.B)
                             a.io.dataOut(1).expect(0.B)
                                a.io.dataOut(2).expect(5.B)
                                   a.io.dataOut(3).expect(5.B)
                          

       }

            }

                   }
