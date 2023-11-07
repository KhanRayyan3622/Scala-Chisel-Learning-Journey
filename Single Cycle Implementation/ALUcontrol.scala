package singlecycle

import chisel3._
import chisel3.util._

class Alu_Control_IO(width: Int, f3: UInt) extends Bundle {

	val aluop = Input(UInt(width.W))
	val func7 = Input(Bool())
	val func3 = Input(f3)
	val control = Output(UInt(5.W))

}

class AluControl extends Module with Config{
	val io = IO(new Alu_Control_IO(aluopWidth, func3))
	io.control := MuxCase("b000".U, Array(

		// R Type 
		(io.aluop === "b000".U && io.func7 === false.B) -> Cat("b0".U, io.func3),
		(io.aluop === "b000".U && io.func7 === true.B) -> Cat("b1".U, io.func3),

		// Srli
		(io.aluop === "b001".U && io.func3 === "b101".U && io.func7 === false.B) -> Cat("b0".U , io.func3),

		//Srai
		(io.aluop === "b001".U && io.func3 === "b101".U && io.func7 === true.B) -> Cat("b1".U , io.func3),

		//SLLI
		(io.aluop === "b001".U && io.func3 === "b001".U) -> Cat("b0".U , io.func3),

		//All Remaining I-Type
		(io.aluop === "b001".U) -> Cat("b0".U , io.func3),

		// Branch
		(io.aluop === "b010".U) -> Cat("b010".U , io.func3),

		//JALR , JAL
		(io.aluop === "b011".U) -> "b11111".U  

		))
}
