import { Component, OnInit } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';

import { Produto } from '../../interface/produto.interface'
import { ExcluirPopupComponent } from '../excluir-popup/excluir-popup.component';
import { RouterModule } from '@angular/router';
import { HeaderComponent } from "../header/header.component";
import { ProdutoService } from '../../service/ProdutoService.service';
import { ExcluirCadeiaPopupComponent } from "../excluir-cadeia-popup/excluir-popup.component";

@Component({
    selector: 'app-index',
    standalone: true,
    imports: [HttpClientModule, CommonModule, RouterModule, ExcluirPopupComponent, HeaderComponent, HeaderComponent, ExcluirCadeiaPopupComponent],
    providers: [ProdutoService],
    templateUrl: './index.component.html',
    styleUrl: './index.component.css'
})
export class IndexComponent implements OnInit {

    constructor(private produtoService: ProdutoService){}

    data: Produto[] = [];
    deletarPopup = false;
    excluirDatas = false;

    produtoParaExcluir: number | null = null    

    confirmarExclusao(id: number) {
        this.deletarPopup = true;
        this.produtoParaExcluir = id;
    }

    esconderPopup() {
        this.deletarPopup = false;
        this.produtoParaExcluir = null;
        this.excluirDatas = false;
    }

    ngOnInit(): void {
        this.produtoService.listar()
            .subscribe({
                next: (response) => {
                    this.data = response;
                },
                error: (error) => {
                    console.error('Error:', error);
                }
            });
    }

    excluirProduto() {
        if (this.produtoParaExcluir) {
            this.produtoService.excluir(this.produtoParaExcluir)
                .subscribe({
                    next: () => {
                        this.ngOnInit()
                        this.esconderPopup();
                    }, error: () => {
                        this.excluirDatas = true
                    }
                })
        }
    }

    excluirTodos() {
        if (this.produtoParaExcluir) {
            this.produtoService.excluirTodos(this.produtoParaExcluir)
                .subscribe({
                    next: () => {
                        this.ngOnInit()
                        this.esconderPopup();
                    }, error: () => {
                        this.excluirDatas = true
                    }
                })
        }
    }
}
