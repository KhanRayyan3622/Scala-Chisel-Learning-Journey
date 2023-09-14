package single_cycle

import chisel3 . _
import chisel3 . util . _
class Datamem extends Module {
  val io = IO(new Bundle {
    val Wr_en = Input(Bool())
    val addr = Input(UInt(32.W))
    val Din = Input(UInt(32.W))
    val Dout = Output(UInt(32.W))
  })

  val memory = Mem (32 , UInt(32.W ) )
  //io.Dout := 0.U

  when (io.Wr_en){
    memory.write(io.addr,io.Din)
    io.Dout := memory.read(io.addr)
  }

  io.Dout := memory.read(io.addr)
} 