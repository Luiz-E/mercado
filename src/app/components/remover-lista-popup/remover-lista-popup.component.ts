import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-remover-lista-popup',
  standalone: true,
  imports: [],
  templateUrl: './remover-lista-popup.component.html',
  styleUrl: './remover-lista-popup.component.css'
})
export class RemoverListaPopupComponent {
    @Output() fecha = new EventEmitter<void>();
    @Output() apaga = new EventEmitter<void>();

    fechar() {
        this.fecha.emit();
    }

    remover() {
        this.apaga.emit();
    }
}
