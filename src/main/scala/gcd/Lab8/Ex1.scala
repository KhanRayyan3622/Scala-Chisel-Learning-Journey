package Lab8
import chisel3._

import chisel3 . util . _

class MaskedRead extends Module {
  val width: Int = 8

  val io = IO(new Bundle {
    val enable = Input(Bool())
    val write = Input(Bool())
    val addr = Input(UInt(10.W))
    val mask = Input(Vec(4, Bool()))
    val dataIn = Input(Vec(4, UInt(width.W)))
    val dataOut = Output(Vec(4, UInt(width.W)))
  })

  val mem = SyncReadMem(1024, Vec(4, UInt(width.W)))

  when(io.write) {
    for (i <- 0 until 4) {
      when(io.mask(i)) {
        mem.write(io.addr, io.dataIn(i), Seq.fill(4)(true.B))
      }
    }
  }

  val readData = mem.read(io.addr, io.enable)

  for (i <- 0 until 4) {
    io.dataOut(i) := Mux(io.mask(i), readData(i), 0.U)
  }
}


// // Write with mask
// mem . write ( io . addr , io . dataIn , io . mask )
// io . dataOut := mem . read ( io . addr , io . enable )
// }