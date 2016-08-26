fn main(){
    let a = 5;

    //All primitive types copies the values from heap and the stack
    let b:i32 = a;
    println!("{}",a);
    println!("{}",b);

}
