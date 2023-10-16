package single_cycle

import chisel3._
import chisel3.util._

class ImmdValGen extends Bundle {
  val imm = Input(UInt(12.W))
  val immd_se = Output(UInt(32.W))
}

class ImmdValGen1 extends Module {
  val io = IO(new ImmdValGen)

  // Sign extend the 12-bit immediate value to 32 bits
  io.immd_se := Cat(Fill(20, io.imm(11)), io.imm)
}
