// package Lab6
// import chisel3._
// import chisel3.tester._
//  import org.scalatest.FreeSpec
//  import chisel3.experimental.BundleLiterals._

//  class Ex3tester extends FreeSpec with ChiselScalatestTester {
//      "ex3  tester" in {
//          test(new to_shot_timer){ a =>
//             a.io.reload.poke(0.B)
//                a.io.reset.poke(0.B)
//                   a.din.reload.poke(4.U)
//          a.clock.step(1)
//          a.io.out.expect(0.B)
//         // a.io.out.expect("b1111".U)
//          }
//         }
//     }