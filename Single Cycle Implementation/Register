package single_cycle

import chisel3._
import chisel3.util._

class Register extends Module {
  val io = IO(new Bundle {
    val ren = Input(Bool())
    val data = Input(UInt(32.W))
    val rs1 = Input(UInt(5.W))
    val rs2 = Input(UInt(5.W))
    val rd = Input(UInt(5.W))
    val out_rs1 = Output(UInt(32.W))
    val out_rs2 = Output(UInt(32.W))
  })

  io.out_rs1 := 0.U
  io.out_rs2 := 0.U

  val regfile = Mem(32, UInt(32.W))

  when(io.ren && io.rd =/= 0.U) {
    regfile(io.rd) := io.data
    
  }.otherwise {
    when(io.rs1 =/= 0.U) {
      io.out_rs1 := regfile(io.rs1)
    }
    
    when(io.rs2 =/= 0.U) {
      io.out_rs2 := regfile(io.rs2)
    }
  }
}
