package  practice

import chisel3 . _
import chisel3.util._

class txrxstate extends Module{

    val io = IO (new Bundle{
        val txs = Input(Bool())
           val busyi = Input(Bool())
              val data = Output(UInt(10.W))
    })

    val Rxc = Module(new rx)
   val Txc = Module(new tx)

    Rxc.io.busy := io.busyi
    Txc.io.tx := io.txs

 Txc.io.ready := Rxc.io.readyo
 Rxc.io.validi := Txc.io.valid
 Rxc.io.datai := Txc.io.data
 io.data := Rxc.io.datai


}

