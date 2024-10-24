import { Component, OnInit } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { HeaderComponent } from "../header/header.component";
import { ExcluirPopupComponent } from "../excluir-popup/excluir-popup.component";
import { RemoverListaPopupComponent } from "../remover-lista-popup/remover-lista-popup.component";
import { DataValidadeService } from '../../service/DataValidadeService.service';
import { DataProduto } from '../../interface/Validade.interface';

@Component({
  selector: 'app-listar-datas',
  standalone: true,
  imports: [HttpClientModule, CommonModule, HeaderComponent, HeaderComponent, ExcluirPopupComponent, RemoverListaPopupComponent],
  providers: [DataValidadeService],
  templateUrl: './listar-datas.component.html',
  styleUrl: './listar-datas.component.css'
})
export class ListarDatasComponent implements OnInit {
    data: DataProduto[] = []
    deletarPopup: boolean = false;
    produtoParaExcluir: string | null = null;
    dataValidade: Date | null= null;

    constructor(private dataValidadeService: DataValidadeService) {}

    ngOnInit(): void {
        this.fetchData();
    }

    fetchData = () => {
        this.dataValidadeService.buscarDatas()
            .subscribe({
                next: (response) => {
                    this.formatarDatas(response)
                },
                error: (error) => {
                    console.error('Error:', error);
                }
            });
    }

    formatarDatas = (response: DataProduto[]) => {
        this.data = response;
        this.data.forEach((item) => {
            let split = item.data.toString().split('-')
            item.dataFormatada = `${split[2]}/${split[1]}/${split[0]}`
        });
    }

    confirmarExclusao(data: Date, codigoBarra: string) {
        this.deletarPopup = true;
        this.dataValidade = data;
        this.produtoParaExcluir = codigoBarra;
    }

    removerDaLista() {
        if (this.produtoParaExcluir && this.dataValidade) {
            this.dataValidadeService.remover(this.produtoParaExcluir, this.dataValidade)
                .subscribe({
                    next: () => {
                        this.fetchData();
                        this.esconderPopup();
                    }
                })
        }
    }

    esconderPopup() {
        this.deletarPopup = false;
        this.produtoParaExcluir = null;
    }
}

