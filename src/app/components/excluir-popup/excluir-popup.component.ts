import { Component, EventEmitter, Output } from '@angular/core';

@Component({
    selector: 'app-excluir-popup',
    standalone: true,
    imports: [],
    templateUrl: './excluir-popup.component.html',
    styleUrl: './excluir-popup.component.css'
})
export class ExcluirPopupComponent {

    @Output() close = new EventEmitter<void>();
    @Output() delete = new EventEmitter<void>();

    cancelar() {
        this.close.emit();
    }

    excluir() {
        this.delete.emit();
    }
}
