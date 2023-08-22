// package lab3
// import chisel3 . _
// import chisel3 . util . _
// class LM_IO_Interface_BranchControl extends Bundle {
// val fnct3 = Input ( UInt (3. W ) )
// val branch = Input ( Bool () )
// val arg_x = Input ( UInt (32. W ) )
// val arg_y = Input ( UInt (32. W ) )
// val br_taken = Output ( Bool () )
// }
// class BranchControl extends Module {
// val io = IO (new LM_IO_Interface_BranchControl )
// io.br_taken := 0.B
// when(io.branch===1.B){
// switch(io.fnct3)
// {
//     is("b000".U){
//         when(io.arg_x===io.arg_y){
//             io.br_taken:=1.B
//         }
//         .otherwise{
//             io.br_taken:=0.B
//         }

//     }
//     is("b001".U){
//         when(io.arg_x=/=io.arg_y){
//             io.br_taken:=1.B
//         }
//         .otherwise{
//             io.br_taken:=0.B
//         }

//     }
//     is("b100".U){
//         when(io.arg_x< io.arg_y){
//             io.br_taken:=1.B
//         }
//         .otherwise{
//             io.br_taken:=0.B
//         }

//     }
//     is("b101".U){
//         when(io.arg_x >= io.arg_y){
//             io.br_taken:=1.B
//         }
//         .otherwise{
//             io.br_taken:=0.B
//         }

//     }
//     is("b110".U){
//         when(io.arg_x< io.arg_y){
//             io.br_taken:=1.B
//         }
//         .otherwise{
//             io.br_taken:=0.B
//         }

//     }
//     is("b111".U){
//         when(io.arg_x>= io.arg_y){
//             io.br_taken:=1.B
//         }
//         .otherwise{
//             io.br_taken:=0.B
//         }

//     }}
// }
//     .otherwise{
//         io.br_taken:=0.B
//     }

// }