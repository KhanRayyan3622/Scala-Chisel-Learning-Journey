package lab3
import chisel3._
import chisel3.util._
class LM_IO_Interface_ImmdValGen extends Bundle {
  val instr = Input ( UInt (32.W ) )
  val immd_c = Output ( SInt (32.W ) )
}
class generator extends Module {
  val io = IO (new LM_IO_Interface_ImmdValGen )

  val immid = WireInit(io.instr(31,20).asSInt())


  io.immd_c := (immid)
}