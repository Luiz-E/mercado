import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Produto } from '../../interface/produto.interface';
import { ProdutoService } from '../../service/ProdutoService.service';

@Component({
  selector: 'app-atualizar-pagina',
  standalone: true,
  imports: [FormsModule, CommonModule, HttpClientModule],
  providers: [ProdutoService],
  templateUrl: './atualizar-pagina.component.html',
  styleUrl: './atualizar-pagina.component.css'
})
export class AtualizarPaginaComponent implements OnInit{

    produto: Produto = {id: -1, codigoBarras: '', descricao: ''};
    erro: string = ''

    constructor(private route: ActivatedRoute, private router: Router, private produtoService: ProdutoService){}

    ngOnInit(): void {
        let id = this.route.snapshot.paramMap.get('id')
        if (id != null) {
            this.produtoService.buscar(id)
            .subscribe({
                next: (response: Produto) => {
                    this.produto = response
                },
                error: (error) => {
                    console.error('Error:', error);
                }
            });}
        }  

        onSubmit() {
            if (this.produto) {
                this.produtoService.atualizar(this.produto)
                    .subscribe({
                        next: () => {
                            this.router.navigate(['index']);
                        },
                        error: (err) => {
                            if (err.status === 400) {
                                this.erro = err.error;
                            } else {
                                this.erro = "Já existe um produto com essas informações.";
                            }
                        }
                    },)
            }
        }
}

