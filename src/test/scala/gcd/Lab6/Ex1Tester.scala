// package Lab6

// import chisel3.tester._
//  import org.scalatest.FreeSpec
//  import chisel3.experimental.BundleLiterals._

//  class Ex1tester extends FreeSpec with ChiselScalatestTester {
//      "packet tester" in {
//          test(new shift_register(10)){ a =>
//          a. io.in.poke("b0010".U)
//          a.clock.step(1)
//          a.io.out.expect("b0010".U)
//          }
//         }
//     }