import React, { useEffect, useState } from 'react';
import { Typography } from '@material-ui/core';
import { createMuiTheme, MuiThemeProvider } from '@material-ui/core/styles';
import MUIDataTable from 'mui-datatables';
import ScrollUpButton from 'react-scroll-up-button';
import { useStyles } from './Styles';


export default function RecursosGrid(){
	const [recurso, setRecurso] = useState([]);
	const [query, setQuery] = useState([]);
	const classes = useStyles();



	useEffect(() => {
		const fetchData = async() => {
			const res = await fetch('/api/recurso');
			const body = await res.json();
			console.log(body)
			setRecurso(body)
		};
		fetchData();
	}, [query]);

	const remove = (id) => {
		return(
			fetch(`api/recurso/${id}`, {
				method: 'DELETE',
			    headers: {
			     'Accept': 'application/json',
			     'Content-Type': 'application/json'
	      		}
			}).then(() => {
	
		    let updatedRecurso = recurso.filter(data => data.id !== id);
		    setRecurso(updatedRecurso);
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

	const groupList = recurso.map(recurso => {
		return([
			recurso.nome,
			recurso.custoHora,
			recurso.vendaHora,
			recurso.vendaHoraLiq,
			recurso.margem,
			recurso.chamadosPlanejados,
			recurso.chamadosRealizados,
			recurso.faturamentoBruto,
			recurso.faturamentoRealizado,
			recurso.brutoPlan,
			recurso.valor,
			recurso.chamadosEncerrados,
			recurso.chamadosEncerradosHora,
			recurso.valorColaborador,
			recurso.horaChamadoHoraEstimada,
			recurso.horaChamadoHoraApontada,
	    ])
	})

	const options = {
		onRowsDelete: (rowsDeleted) => {
			const idDelete = rowsDeleted.data.map(row => recurso[row.dataIndex].id);
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
			<MUIDataTable title={type("Lista de Recursos")}
				columns={["Nome", "Custo/Hora", "Venda/Hora", "Venda/Hora Liq", "Margem", "Chamados Planejados", "Chamados Realizados",
					"Faturamento Bruto", "Faturamento Planejado", "Bruto/Planejado", "Valor", "Chamados Encerrados", 
					"Chamados Encerrados em Hora", "Valor/Colaborador",
					"Hora Chamado/ Hora Estimada", "Hora Chamado/ Hora Apontada"
				]}
				data={groupList} options={options}
			/>
			<ScrollUpButton />
		</MuiThemeProvider>
	)
}