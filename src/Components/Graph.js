import React, { useEffect, useState } from 'react';
import { Grid } from '@material-ui/core';
import { VictoryGroup, VictoryBar, VictoryChart, VictoryStack } from 'victory';

export default function Graph(props){
	const [data, setData] = useState([]);


	const fetchData = async() => {
		const res = await fetch('/api/chamado');
		const body = await res.json();			
		setData(body);
	};

	useEffect(() => {
		fetchData();
	}, [])


	const groupBy = (array, func) => {
		var helper = {};
		data.forEach( function(resultData){
			var instance = JSON.stringify( func(resultData));
			helper[instance] = helper[instance] || [];
			helper[instance].push(resultData);  
		});
		return Object.keys(helper).map( function( instance ){
			return helper[instance]; 
		})
	}

	var chamadoOperacaoStatus = groupBy(data, function(item){
		return [item.operacao, item.statusData];
	});

	/*const numChamadoStatus = chamadoOperacaoStatus.reduce((acc, resultData) => (
		acc[resultData.statusData] = (
			acc[resultData.statusData] + 1 || 1
		), acc
	), {});

	const numChamadoOperacao = data.reduce((acc, resultData) => (
		acc[resultData.operacao] = (
			acc[resultData.operacao] + 1 || 1
		), acc
	), []);*/

	return(
		<Grid container >
			<Grid item >
	        <VictoryChart domainPadding={{ x: 50 }} width={400} height={400} style={{parent: {maxWidth: "50%"} }}>
	            <VictoryGroup offset={20} style={{ data: { width: 15 } }} >
	            {console.log(chamadoOperacaoStatus[0])}
	              <VictoryStack colorScale={"red"}>
	                {chamadoOperacaoStatus.map((returnData, index) => {
	                	return <VictoryBar key={index} data={returnData}/>;
	                })}
	              </VictoryStack>
	            </VictoryGroup>
	          </VictoryChart>
	        </Grid>
	    </Grid>
	)
}