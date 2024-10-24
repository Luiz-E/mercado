import { Component, inject } from '@angular/core';
import { HeaderComponent } from "../header/header.component";
import { FormsModule } from '@angular/forms';
import { Caminho } from '../../url';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';
import { DataValidadeService } from '../../service/DataValidadeService.service';
import { CriarDataValidade } from '../../interface/CriarValidade.interface';
import { HttpClientModule } from '@angular/common/http';
import { ProdutoService } from '../../service/ProdutoService.service';

@Component({
  selector: 'app-adicioanr-produto',
  standalone: true,
  imports: [HeaderComponent, FormsModule, CommonModule, HttpClientModule],
  providers: [DataValidadeService, ProdutoService],
  templateUrl: './adicionar-produto.component.html',
  styleUrl: './adicionar-produto.component.css'
})
export class AdicionarProdutoComponent {
    
    vencimento: CriarDataValidade = {id: null, codigoBarra: null, ano: null, data: null, dataIncompleta: false, mes: null}
    descricao: string | null = null;
    erro = {mensagem: null, codigo: -1}
    produtoNovo: boolean = false;
    constructor (
        private router: Router,
        private dataValidadeService: DataValidadeService,
        private produtoService: ProdutoService){}

    onSubmit() {
        if (this.vencimento.codigoBarra) {
            if (!this.vencimento.data && this.vencimento.dataIncompleta && this.vencimento.ano && this.vencimento.mes) {
                const ano = parseInt(this.vencimento.ano)
                this.vencimento.data = new Date(ano, this.vencimento.mes, 1);
            }
            if (this.vencimento.data) {
                if (this.produtoNovo == true && this.descricao != null) {
                    console.log(this.vencimento)
                    this.produtoService.criarNovo({descricao: this.descricao, codigoBarras: this.vencimento.codigoBarra, id: -1})
                    .subscribe({
                        next: () => {
                            this.dataValidadeService.salvarValidade(this.vencimento)
                                .subscribe({
                                    next: () => {
                                        this.router.navigate(['index']);
                                    },
                                    error: (err) => {
                                        this.vencimento = {id: null, codigoBarra: this.vencimento.codigoBarra, ano: this.vencimento.ano, data: null, dataIncompleta: this.vencimento.dataIncompleta, mes: this.vencimento.mes}
                                        this.erro.mensagem = err.error;
                                        if (err.status === 501) {
                                            this.produtoNovo = true;
                                        }
                                    }
                            })
                        }
                    })
                } else {
                    this.dataValidadeService.salvarValidade(this.vencimento)
                        .subscribe({
                            next: () => {
                                this.router.navigate(['index']);
                            },
                            error: (err) => {
                                this.vencimento = {id: null, codigoBarra: this.vencimento.codigoBarra, ano: this.vencimento.ano, data: null, dataIncompleta: this.vencimento.dataIncompleta, mes: this.vencimento.mes}
                                this.erro.mensagem = err.error;
                                if (err.status === 501) {
                                    this.produtoNovo = true;
                                }
                            }
                        })
                }
            }
        }
    }

    }
