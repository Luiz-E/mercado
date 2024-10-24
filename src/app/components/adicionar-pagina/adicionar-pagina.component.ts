import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { ProdutoService } from '../../service/ProdutoService.service';
import { Produto } from '../../interface/produto.interface';

@Component({
  selector: 'app-adicionar-pagina',
  standalone: true,
  imports: [FormsModule, CommonModule, HttpClientModule],
  providers: [ProdutoService],
  templateUrl: './adicionar-pagina.component.html',
  styleUrl: './adicionar-pagina.component.css'
})
export class AdicionarPaginaComponent {
    produto: Produto = {id: -1, descricao: '', codigoBarras: ''};
    erro: string | null = null;

    constructor(private router: Router, private produtoService: ProdutoService){}
    onSubmit() {
        if (this.produto) {
            console.log(this.produto)
            this.produtoService.criarNovo(this.produto)
                .subscribe({
                    next: () => {
                        this.router.navigate(['index']);
                    },
                    error: (err) => {
                        if (err.status === 400) {
                            this.erro = err.error;
                        } else {
                            this.erro = "Ocorreu um erro inesperado.";
                        }
                    }
                })
        }
    }
}
