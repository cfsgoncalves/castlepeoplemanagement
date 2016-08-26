fn main(){
    //Borrowing -> just passing references
    let v:Vec<i32> = vec![1,2,3];

    let c: &i32 = &v[0];

    println!("{}",c);
    println!("{}",v[0]);





}
