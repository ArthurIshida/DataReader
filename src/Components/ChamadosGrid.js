import React, { useEffect, useState } from 'react';
import { Typography } from '@material-ui/core';
import { createMuiTheme, MuiThemeProvider } from '@material-ui/core/styles';
import MUIDataTable from 'mui-datatables';
import { useStyles } from './Styles';


export default function ChamadosGrid(){
	const [chamado, setChamado] = useState([]);
	const [query, setQuery] = useState([]);
	const classes = useStyles();



	useEffect(() => {
		const fetchData = async() => {
			const res = await fetch('/api/chamado');
			const body = await res.json();
			console.log(body)
			setChamado(body)
		};
		fetchData();
	}, [query]);

	const remove = (id) => {
		return(
			fetch(`api/chamado/${id}`, {
				method: 'DELETE',
			    headers: {
			     'Accept': 'application/json',
			     'Content-Type': 'application/json'
	      		}
			}).then(() => {
	
		    let updatedChamado = chamado.filter(chamado => chamado.id !== id);
		    setChamado(updatedChamado);
		    setQuery(!query);
			})
		)
	}

	const type = (props) => {
		return(
			<Typography className={classes.textTitle} >
				{props}
			</Typography>
		)
	}

	const groupList = chamado.map(chamado => {
		return([
			chamado.id,
			chamado.operacao,
			chamado.grupo,
			chamado.subGrupo,
			chamado.categorizacao,
			chamado.tipificacao,
			chamado.recurso,
			chamado.severidade,
			chamado.statusData,
			chamado.tecnologia,
			chamado.dataAbertura,
			chamado.dataFechamento,
			chamado.fechado,
			chamado.contagemSla,
			chamado.metaSla,
			chamado.indiceMetaSla,
			chamado.contagemSlaHora,
	    ])
	})

	const options = {
		onRowsDelete: (rowsDeleted) => {
			const idDelete = rowsDeleted.data.map(row => chamado[row.dataIndex].id);
			remove(idDelete);
		},
		pagination: false,
		textLabels: {
			body: {
				noMatch: "",
			}
		},
	}
	
	const getMuiTheme = createMuiTheme({
		overrides: {
			MuiTableCell: {
				root: {
					padding: '8px',
					fontSize: '11px'
				}
			},
		}
	})

	return(
		<MuiThemeProvider theme={getMuiTheme} >
			<MUIDataTable title={type("Chamados List")}
				
				columns={["ID", "Operação", "Grupo", "Sub-Grupo", "Categorização", "Tipificação", "Recurso",
					"Severidade", "Status", "Tecnologia", "Data de Abertura", "Data de Fechamento", "Fechado S/N", "Contagem/SLA",
					"Meta SLA", "Índice Meta/Sla", "Contagem/SLA - Hora"
				]}
				data={groupList} options={options}
			/>
		</MuiThemeProvider>
	)
}