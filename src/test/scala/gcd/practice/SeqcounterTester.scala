package practice

import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec
import chisel3.experimental.BundleLiterals._

class SeqcounterTester extends FreeSpec with ChiselScalatestTester{
    "Seq counter Tester file " in {
    test(new Seqcontroller){ a=>
    a.io.opcode.poke(3.U)
    a.io.zero.poke(0.B)
    a.io.rst_.poke(0.B)
    a.io.mem_rd.expect(1.B)
    a.io.load_ir.expect(1.B)
    a.io.halt.expect(0.B)
    a.io.inc_pc.expect(0.B)
    a.io.load_ac.expect(0.B)
    a.io.load_pc.expect(0.B)
    a.io.mem_wr.expect(0.B)
    a.clock.step(3)
    }
}
}
    

