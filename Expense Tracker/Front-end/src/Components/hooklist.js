import React, { useState} from 'react';
function Hookslist(props) {
    const[msg]=useState("Transaction History");
    
    const[list,updatelist]=useState(
        [
            
        ]);
    const update=()=>{
        let newname=document.getElementById("newname").value;
        let newcost=document.getElementById("newcost").value;
        updatelist(lst=>[...list,{id:`${list.length+1}`,name:newname,cost:newcost}])
    }
    return (
        <>
    <h1>{msg}</h1> 

    <table style={{border:"1px solid"}}>
        {list.map(lst=>(<tr style={{border:"1px solid"}}><td style={{border:"1px solid"}}>
            {lst.name}</td><td>{lst.cost}</td></tr>))}
    </table>
    
    <br/> 
    
    <input type="text" id="newname" placeholder='Add your Expense'/><br/>
    <input type="text" id="newcost" placeholder='Add your cost'/><br/><br/>
    <button style={{backgroundColor:"rgb(162, 161, 165)"}} onClick={update}>Update</button>
    </>
    );
    
}

export default Hookslist;