package Lab6

import chisel3 . _
import chisel3 . util . _

class Queue extends Module {
val io = IO ( new Bundle {
val in = Flipped ( Decoupled ( UInt (8. W ) ) ) // valid = Input , bits = Input
val out = Decoupled ( UInt (8. W ) ) // valid = Output , bits = Output
})
val queueA = Queue(io.in,6)
val  queueB = Queue (queueA,6)
}
//println ( chisel3 . Driver . emitVerilog (new Pipe ) )


