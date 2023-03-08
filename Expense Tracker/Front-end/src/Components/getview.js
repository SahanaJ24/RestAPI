import React,{ useEffect,useState} from "react";
import './CSS/view.css'
import axios from "axios";
function GetView(){
    const [content, addContent]=useState([]);
    useEffect(()=>{

    axios.get('http://localhost:8080/exp').then(function (response) {
    addContent(response.data);
    });
    })

    const [deleteId,addDeleteId]=useState("");
    const handleDelete=()=>{
        axios.delete(`http://localhost:8080/exp/${deleteId}`)
        .then((response)=>console.log(response));
    }
    
    const[editContent,addEditContent]=useState({"id":"","status":"","amount":"","expense":"","date":""});

    const handleFormChange=(event)=>{
        const{id,value}=event.target;
        addEditContent({...editContent,[id]:value});
        // console.log(editContent);
    }
    const handleEdit=()=>{
        axios.put('http://localhost:8080/exp',editContent);
    }

    return(
        <div id="outer">
            <h3>DISPLAY TRANSACTION</h3>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Status</th>
                    <th>Amount</th>
                    <th>Date</th>
                    <th>Expense</th>
                </tr>
                {content.map((value)=>(
                    <tr>
                        <td>{value.id}</td>
                        <td>{value.status}</td>
                        <td>{value.amount}</td>
                        <td>{value.date}</td>
                        <td>{value.expense}</td>
                    </tr>
                ))}
                    
            </table>
            <br/> <br/> <br/> <br/> 
            <div id="deleteUser">
            <h3>DELETE</h3>
                    <input  id="delete-input" type="text" placeholder="Enter the ID to delete" 
                    style={{width:140,height:26,color:"black"}} onChange={(event)=>{addDeleteId(event.target.value)}}></input>
                    <input id="delete-button" type="button" value="DELETE" style={{"backgroundColor":"red",width:140,height:30,color:"black"}} onClick={handleDelete}></input>
                    <br/><br/><br/>
            </div>
            <div id="Edituser">
                <h3>UPDATE</h3>
                <label>ID</label>
                
                <input type="text" id="id" onChange={handleFormChange} style={{"color":"black","height":20,"width":200}}></input>
                <br/><br/>
                <label>Status</label>
                
                <input type="text" id="status" onChange={handleFormChange} style={{"color":"black","height":20,"width":200}}></input><br/><br/>
                <label>Amount</label>
                <input type="text" id="amount" onChange={handleFormChange} style={{"color":"black","height":20,"width":200}}></input><br/><br/>
                <label>Expense</label>
                <input type="text" id="expense" onChange={handleFormChange} style={{"color":"black","height":20,"width":200}}></input><br/><br/>
                <label>Date</label>
                <input type="date" id="date" onChange={handleFormChange} style={{"color":"black","height":20,"width":200}}></input><br/><br/>
                <input id="edit-button" type="button" value="EDIT" style={{"color":"Black",backgroundColor:"Green","height":30,"width":120}} onClick={handleEdit}></input><br/>
            </div>

            
        </div>
    )
}
export default GetView;