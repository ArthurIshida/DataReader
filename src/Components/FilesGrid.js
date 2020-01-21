import React, { useEffect, useState } from 'react';
import { Typography } from '@material-ui/core';
import { createMuiTheme, MuiThemeProvider } from '@material-ui/core/styles';
import MUIDataTable from 'mui-datatables';
import { useStyles } from './Styles';


export default function FilesGrid(){
	const [file, setFile] = useState([]);
	const [query, setQuery] = useState([]);
	const classes = useStyles();



	useEffect(() => {
		const fetchData = async() => {
			const res = await fetch('/api/files');
			const body = await res.json();
			setFile(body)
		};
		fetchData();
	}, [query]);

	const remove = (id) => {
		return(
			fetch(`api/files/${id}`, {
				method: 'DELETE',
			    headers: {
			     'Accept': 'application/json',
			     'Content-Type': 'application/json'
	      		}
			}).then(() => {
	
		    let updatedFiles = file.filter(file => file.id !== id);
		    setFile(updatedFiles);
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

	const groupList = file.map(file => {
		return([
			file.id,
			file.name,
			file.creationDateTime,
			file.location
	    ])
	})

	const options = {
		onRowsDelete: (rowsDeleted) => {
			const idDelete = rowsDeleted.data.map(row => file[row.dataIndex].id);
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
			<MUIDataTable title={type("Files List")}
				columns={["ID", "Name", "Creation Date", "Location" ]}
				data={groupList} options={options}
			/>
		</MuiThemeProvider>
	)
}