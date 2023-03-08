import React, { Component } from 'react'
 import './CSS/expense.css'
 import axios from "axios";
 import bg2 from '../Assets/bg2.jpeg'
import GetView from './getview';
import Delete from './delete';

class Expense extends Component {
        constructor(props){
                super(props);
                this.state = {"amount":0,"status":"Credit","expense":"","total":0,"date":""}
                this.updateBalance = this.updateBalance.bind(this)
    }
    updateBalance=()=>{
        axios({
            method: 'post',
            url: 'http://localhost:8080/exp',
            data: this.state, 
            headers: {
            'Content-Type': 'application/json'
            }, 
          })
        if(this.state.status==='Credit')
        this.setState({total:parseInt(this.state.amount)+parseInt(this.state.total)});
        else
        this.setState({total:this.state.amount-this.state.total});
    }
    render() {
        return (
        <div 
        style={{backgroundImage: `url(${bg2})`, backgroundRepeat: 'no-repeat', 
            backgroundSize:"cover", 
            width:'100%' ,
            height:'150%'}}
            >
            
            {/* <GetView/> */}
        <div id="wrapper"><br/><br/>
                <h1>Expense Tracker</h1>
                <h2>Balance: {this.state.total}</h2><br/>
                <button style={{backgroundColor:"rgb(96, 216, 66)",fontSize:20}} onClick={()=>this.setState({status:"Credit"})}>Credit</button>
                <button style={{backgroundColor:"rgb(245, 38, 38)",fontSize:20}} onClick={()=>this.setState({status:"Debit"})}>Debit</button>
                <br/><br/>
                <h2>{this.state.status}</h2><br/>
                <form>
                <input type="text" id="amount" pattern="[0-9]" required placeholder='Enter the Amount'
                 style={{fontSize:15,height:25,color:'black'}}
                onChange={(event)=>{this.setState({"amount":event.target.value})}}
                /><br/>
                <input type="text" placeholder='Expense Detail'
                style={{fontSize:15,height:25,color:'black'}}
                 onChange={(event)=>{this.setState({expense:event.target.value})}}
                ></input><br/>
                <input type="date" placeholder='Date'
                style={{fontSize:15,height:25,color:'black'}}
                onChange={(event)=>{this.setState({date:event.target.value})}}
                >
                    </input><br/>
                
                </form>
                <button style={{backgroundColor:"rgb(56, 55, 55)",fontSize:18,height:30}} onClick={this.updateBalance}>Add Transaction</button>
                
                {/* <br/><br/><br/> */}

        </div>
        <div id="parti2">
        <GetView/>
        </div>
        </div>
        );
                
    }
}
export default Expense;