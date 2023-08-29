package practice
import chisel3 . _
import chisel3.util._
import scala.annotation.switch
import chisel3.experimental.ChiselEnum

class tx extends Module {
  val io = IO(new Bundle{
    //Input
    val tx = Input (Bool())
     val ready = Input (Bool())
      val valid = Output (Bool())
       val data = Output (UInt(4.W))
        //  val datarx = Output (UInt(4.W))
        //  val busy = Input(Bool())
  })
         object State extends ChiselEnum
         {
          val Idle ,Txs ,Valid = Value
         }
         io.valid := 0.B
         io.data := 0.B

   import State._
   val states = RegInit(Idle)
   val valid = RegInit(Valid)
   switch(Idle)
   {
    is(Idle)
    {
      states := Txs
      io.valid := 0.B
      io.data := 0.U
    }
    is(Txs)
    {
      when(io.tx === 1.B){
      states := Valid
      io.valid := 1.B
      io.data := 5.U
      }
      .otherwise{
      states := Txs
    }
    }
    
    is(Valid){
      when(io.ready === 1.B){
        states := Txs
        io.valid := 0.B
        io.data :=5.U
      }
    }
  }
}
//   //   is(Valid){
//   //     when(io.ready===1.B){
//   //     states :=Txs
//   //     io.data := io.datarx
//   //     }
      

//   //      .elsewhen(states === Valid){
//   //  when (io.busy === 1.B){
//   //   io.ready :=0.B 
//   //  }
   
//   //   .otherwise{
//   //     io.ready := 1.B
//   //   }
//   //  }
//   //   }
    
//   }}

// //   class Rx extends Module {
// // val io = IO (new tx )
// // val busy = Input (Bool())
// //      val validi = Input (Bool())
// //       val readyo = Output (Bool())
// //        val datai = Input (UInt(4.W))
// //       when(io.ready===1.B){
// //       states :=Txs
// //       io.data := io.datarx
// //       }
// //        .elsewhen(states === Valid){
// //    when (io.busy === 1.B){
// //     io.ready :=0.B 
// //    }
   
// //     .otherwise{
// //       io.ready := 1.B
// //     }
// //    }
// //     }

// class Main extends Module {
//     val io=IO(new Bundle{
//     val txin = Input (Bool())
//     val datarx = Output (UInt(4.W))
//     val busy = Input(Bool())
//     })
// }

// val Rxc = Module(new Rx)
// val Txc = Module(new tx)

// Rxc.io.busy := io.busyin
// Txc.io.tx := io.txin

// Txc.io.readyi := Rxc.io.readyo
// Rxc.io.validi := Txc.io.valido
// Rxc.io.datai := Txc.io.datao
// io.data := Rxc.io.datai




























