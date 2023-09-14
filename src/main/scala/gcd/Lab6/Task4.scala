package Lab6

import chisel3._
import chisel3.util._
class up_down_counter ( val max : Int = 10) extends Module {
val io = IO (new Bundle {
val out = Output ( UInt ( log2Ceil ( max ) . W ) )
val up_down = Input ( Bool () )
})
val counter = RegInit (0. U(4.W)  )

io.out:=Mux(io.up_down,counter+1.U,counter-1.U)


}