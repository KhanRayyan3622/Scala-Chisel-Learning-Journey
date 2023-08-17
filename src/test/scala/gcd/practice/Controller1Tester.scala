// package practice

// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec
// import chisel3.experimental.BundleLiterals._

// class Controller1Tester extends FreeSpec with ChiselScalatestTester{
//     "Controller1Tester file " in {
//     test(new Controller){ a=>
     
//     a.io.zero.poke(0.B)
//     a.io.phase.poke(3.U)
//      a.io.opcode.poke(3.U)
//      a.clock.step(20)
//     a.io.sel.expect(1.B)
//     a.io.rd.expect(1.B)
//     a.io.id_ir.expect(1.B)
//     a.io.inc_pc.expect(0.B)
//     a.io.halt.expect(0.B)
//     a.io.id_pc.expect(0.B)
//     a.io.data_c.expect(0.B)
//     a.io.id_ac.expect(0.B)
//     a.io.wr.expect(0.B)
//     }
//     }
// }