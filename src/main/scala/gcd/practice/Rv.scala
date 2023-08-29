package practice
import chisel3 . _
import chisel3.util._
import scala.annotation.switch
import chisel3.experimental.ChiselEnum

class rx extends Module {
  val io = IO(new Bundle{
  val busy = Input (Bool())
  val validi = Input (Bool())
   val readyo = Output (Bool())
    val datai = Input (UInt(4.W))    
  })
 val datareg = RegInit(0.U(4.W))
  when(io.busy ===1.B)
  {
    io.readyo := 0.B

  }
  .otherwise
  {
    io.readyo :=1.B
  }

  when(io.validi===1.B && io.readyo === 1.B)
  {
    datareg :=io.datai 
  }

}